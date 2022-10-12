import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ticket } from '../model/ticket';
import { Observable, map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private ticketsUrl: string;

  constructor(private http: HttpClient) {
    this.ticketsUrl = 'http://localhost:8080/tickets';
  }

  public findAll(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(this.ticketsUrl);
  }

  public save(ticket: Ticket): Observable<Ticket> {
    console.log(ticket);
    return this.http.post<Ticket>(this.ticketsUrl, ticket);
  }

  public update(ticket: Ticket): Observable<Ticket> {
    console.log(ticket);
    return this.http.put<Ticket>(`${this.ticketsUrl}/${ticket.id}`, ticket);
  }

  public get(id: number): Observable<Ticket> {
    return this.http.get<Ticket>(`${this.ticketsUrl}/${id}`).pipe(
      map(response => response)
    )
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.ticketsUrl}/${id}`);
  }
}
