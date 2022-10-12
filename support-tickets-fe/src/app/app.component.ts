import { Component, ViewChild, OnInit } from '@angular/core';

import { MatTable } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { TicketService } from './service/ticket.service';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';

import { Ticket, TicketStates } from "./model/ticket"
import { validateHorizontalPosition } from '@angular/cdk/overlay';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title: string;
  displayedColumns: string[] = ['id', 'title', 'description', 'state', 'modified', 'action'];
  dataSource: Ticket[];

  @ViewChild(MatTable, {static:true}) table: MatTable<any>;

  constructor(public dialog: MatDialog, 
    private ticketService: TicketService) {
      this.title = 'Support ticket system';
  }

  ngOnInit(): void {
    this.ticketService.findAll().subscribe(
      data => {
        this.dataSource = data;
        console.log(this.dataSource.length);
    });  
  }

  openDialog(action: string, obj: []) {
    //obj.action = action;
    console.log('dialog action = ' + action);
    const dialogRef = this.dialog.open(DialogBoxComponent, {
      width: '350px',
      //height: '300px',
      data: obj
    });
    dialogRef.componentInstance.action = action;

    dialogRef.afterClosed().subscribe(result => {
      if(result.event == 'Add'){
        this.addRowData(result.data);
      }else if(result.event == 'Update'){
        this.updateRowData(result.data);
      }else if(result.event == 'Delete'){
        this.deleteRowData(result.data);
      }
    });
  }

  addRowData(row_obj: Ticket ) {
    var d = new Date();
    row_obj.status = TicketStates.TODO;
    this.ticketService.save(row_obj).subscribe(result => {
      this.dataSource.push(result);
      this.table.renderRows();
    });
  }

  updateRowData(row_obj: Ticket ) {
    this.ticketService.update(row_obj).subscribe(updatedTicket => {
      this.dataSource = this.dataSource.filter((value,key)=>{
        if(value.id == row_obj.id) {
          value.title = updatedTicket.title;
          value.description = updatedTicket.description;
          value.modified = updatedTicket.modified;
          value.status = updatedTicket.status;
        }
        return true;
      });
      this.table.renderRows();
    });
  }

  deleteRowData(row_obj: Ticket ) {
    this.ticketService.delete(row_obj.id).subscribe(any => {
      this.dataSource = this.dataSource.filter((value,key)=>{
        return value.id != row_obj.id;
      });
    })
    
  }

}