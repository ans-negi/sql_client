import {AfterViewInit, Component, QueryList, ViewChildren} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Angular5Csv} from "angular5-csv/dist/Angular5-csv";
import {HttpClient} from "@angular/common/http";
import { Injectable } from "@angular/core";

class Table_Datasource{
  columns:any;
  data:MatTableDataSource<any>;
  constructor() {
    this.columns = [];
    this.data = new MatTableDataSource([]);;
  }
}

let table_datasource = new Table_Datasource(); // selected table result
let query_datasource = new Table_Datasource(); // query result (null if invalid)
let curr_datasource = new Table_Datasource(); // used for download
let search_results:string[] = [];
let query_message = '';
let baseurl = "http://localhost:8080/"
let limit = 50;


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements AfterViewInit
{
  constructor(private http:HttpClient) {}

  title = 'Data Viewer';
  limit = limit;
  search_results = search_results;

  table_datasource = table_datasource;
  query_datasource = query_datasource;
  curr_datasource = curr_datasource;
  query_message = query_message;

  @ViewChildren(MatPaginator) paginator = new QueryList<MatPaginator>();

  ngAfterViewInit()
  {
    table_datasource.data.paginator =  this.paginator.toArray()[0];
    query_datasource.data.paginator =  this.paginator.toArray()[1];
  }

  process_query(query: string, datasource:Table_Datasource, http, user_selected:boolean)
  {
    datasource.data = new MatTableDataSource([]);
    datasource.columns = [];

    query_message = 'INTERNAL ERROR';
    http.get(baseurl+`query?q=${query}`).subscribe((res)=> {

      let res_datasource = res.data;
      this.query_message = res.message;

      if (this.query_message == 'SUCCESS') {
        datasource.data = new MatTableDataSource(res_datasource);
        for (let v in datasource.data.data[0]) {
          datasource.columns.push(v);
        }
      }else{
        this.query_message = "Database not found";
      }

      if(user_selected){ // user selected query?
        this.table_datasource.data.paginator = this.paginator.toArray()[0]; // update paginator
      }else{
        this.query_datasource.data.paginator = this.paginator.toArray()[1];
      }
      this.curr_datasource.data = res_datasource;
    });
  }

  after_user_query(q:string)
  {
    this.process_query(q,query_datasource,this.http, false);
    //query_datasource.data.paginator =  this.paginator.toArray()[1]; // update paginator
    //this.query_message = query_message; // update local copy with global copy
    //curr_datasource = query_datasource;
  }

  after_user_select_table(table_name:string)
  {
    let q = `SELECT * FROM ${table_name} LIMIT ${this.limit};`;
    console.log(q);
    this.process_query(q,table_datasource,this.http, true)
    //table_datasource.data.paginator =  this.paginator.toArray()[0];
    //curr_datasource = table_datasource;
  }

  after_tab_change(idx:number)
  {
    this.curr_datasource = idx ? query_datasource : table_datasource;
  }

  after_user_limit_table(limit:number)
  {
    this.limit = Math.max(0,limit);
  }

  after_user_search_table(table_name:string)
  {
    this.http.get(baseurl+`search`).subscribe((res)=> {
        this.search_results = [];
        var words:string[] = Object.values(res);
        for(var i=0;i<words.length;i+=1){
          if (words[i].toUpperCase().indexOf(table_name.toUpperCase()) > -1) { // check substring
            this.search_results.push(words[i]);
          }
        }
    });
  }

  export_data()
  {
    new Angular5Csv(this.curr_datasource.data,`${Math.random().toString(36).slice(2)}`);
  }
}
