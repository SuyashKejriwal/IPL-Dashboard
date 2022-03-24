import { Component, OnInit } from '@angular/core';
import { Team } from '../models/team';
import { HttpServiceService } from '../service/http-service.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private http: HttpServiceService) { }

  Teams:Team[];
  ngOnInit(): void {
    this.http.getAllTeams().subscribe((res)=>{
      this.Teams=res;
      console.log(this.Teams);
    })
  }

}
