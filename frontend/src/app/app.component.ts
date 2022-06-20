import {AfterViewInit, Component, QueryList, ViewChildren} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {Angular5Csv} from "angular5-csv/dist/Angular5-csv";

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
let query_message = '';

function process_query(query: string, datasource:Table_Datasource)
{
  console.log(query);
  datasource.data = new MatTableDataSource([]);
  datasource.columns = [];

  // get data(payload, valid_flag, message) from server
  let valid = false;

  query_message = 'failed due to error 123456789';
  if (query == 'working' || query == 'SELECT * FROM Boots LIMIT 50'){
    valid = true;
    query_message = 'success';
  }

  if(valid) {
    datasource.data = new MatTableDataSource(RESULT_DATA);
    for (let v in datasource.data.data[0]) {
      datasource.columns.push(v);
    }
  }else{

  }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements AfterViewInit
{
  title = 'SQL Client';
  search_results: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];

  table_datasource = table_datasource;
  query_datasource = query_datasource;
  curr_datasource = curr_datasource;
  query_message = query_message;
    //process_query("gg",table_datasource); // selected table result

  @ViewChildren(MatPaginator) paginator = new QueryList<MatPaginator>();

  ngAfterViewInit()
  {
    table_datasource.data.paginator =  this.paginator.toArray()[0];
    query_datasource.data.paginator =  this.paginator.toArray()[1];
  }

  after_user_query(q:string)
  {
    process_query(q,query_datasource);
    query_datasource.data.paginator =  this.paginator.toArray()[1]; // update paginator
    this.query_message = query_message; // update local copy with global copy
    curr_datasource = query_datasource;
  }

  after_user_select_table(table_name:string)
  {
    let q = `SELECT * FROM ${table_name} LIMIT 50`;
    process_query(q,table_datasource)
    table_datasource.data.paginator =  this.paginator.toArray()[0];
    curr_datasource = table_datasource;
  }

  after_tab_change(idx:number)
  {
    curr_datasource = idx ? query_datasource : table_datasource;
  }

  export_data()
  {
    new Angular5Csv(curr_datasource.data.data,`${Math.random().toString(36).slice(2)}`);
  }
}

let RESULT_DATA = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
  {position: 11, name: 'Sodium', weight: 22.9897, symbol: 'Na'},
  {position: 12, name: 'Magnesium', weight: 24.305, symbol: 'Mg'},
  {position: 13, name: 'Aluminum', weight: 26.9815, symbol: 'Al'},
  {position: 14, name: 'Silicon', weight: 28.0855, symbol: 'Si'},
  {position: 15, name: 'Phosphorus', weight: 30.9738, symbol: 'P'},
  {position: 16, name: 'Sulfur', weight: 32.065, symbol: 'S'},
  {position: 17, name: 'Chlorine', weight: 35.453, symbol: 'Cl'},
  {position: 18, name: 'Argon', weight: 39.948, symbol: 'Ar'},
  {position: 19, name: 'Potassium', weight: 39.0983, symbol: 'K'},
  {position: 20, name: 'Calcium', weight: 40.078, symbol: 'Ca'},
];
