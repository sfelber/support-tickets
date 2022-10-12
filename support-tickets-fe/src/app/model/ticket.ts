export class Ticket {
    id: number;
	title: string;
	status: TicketStates;
	description: string;
	modified: string;
}

export enum TicketStates {
	TODO = "TODO",
	DOING = "DOING",
	DONE = "DONE"
}
