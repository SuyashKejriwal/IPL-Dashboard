import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../service/http-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TeamDetails } from '../models/team-details';
import { Match } from '../models/match';
@Component({
  selector: 'app-teams-page',
  templateUrl: './teams-page.component.html',
  styleUrls: ['./teams-page.component.css']
})
export class TeamsPageComponent implements OnInit {

  constructor(private http:HttpServiceService,
    private activatedRoute:ActivatedRoute) { }

    teamName: String;
    teamInfo: TeamDetails;
    LastMatches: Match[];
  ngOnInit(): void {
     
    this.activatedRoute.params.subscribe((params)=>{
      this.teamName=params['teamName'];
    })

    console.log('Team name is ');
    console.log(this.teamName);
    this.http.getTeamInfo(this.teamName).subscribe((res)=>{
      console.log(res);
      this.teamInfo=res;
      console.log(this.teamInfo);
      this.LastMatches=this.teamInfo.latestMatches;
    })
      
  }

}
