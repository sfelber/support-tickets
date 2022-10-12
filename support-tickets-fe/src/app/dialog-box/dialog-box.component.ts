import { Component, Inject, Optional } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { Ticket, TicketStates } from "../model/ticket"

@Component({
  selector: 'app-dialog-box',
  templateUrl: './dialog-box.component.html',
  styleUrls: ['./dialog-box.component.css']
})
export class DialogBoxComponent {

  action: string;
  local_data: Ticket;

  ticketStates: TicketStates;
  ticketStateEnumKeys: string[];

  constructor(
    public dialogRef: MatDialogRef<DialogBoxComponent>,
    @Optional() @Inject(MAT_DIALOG_DATA) public data: Ticket,
    @Inject(MAT_DIALOG_DATA) public dialog_action: string) {
    
    this.local_data = {...data};
    this.action = dialog_action;
    this.ticketStateEnumKeys = Object.keys(TicketStates);
   
  }

  doAction(){
    this.dialogRef.close({event:this.action, data:this.local_data});
  }

  closeDialog(){
    this.dialogRef.close({event:'Cancel'});
  }

}
