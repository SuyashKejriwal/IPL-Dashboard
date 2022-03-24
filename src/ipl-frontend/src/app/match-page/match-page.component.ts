import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Match } from '../models/match';
import { HttpServiceService } from '../service/http-service.service';


@Component({
  selector: 'app-match-page',
  templateUrl: './match-page.component.html',
  styleUrls: ['./match-page.component.css']
})
export class MatchPageComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,
    private http:HttpServiceService) { }
  teamName: String;
  year: number;
  matches: Match[];
  ngOnInit(): void {

    this.activatedRoute.params.subscribe((params)=>{
      this.teamName=params['teamName'];
      this.year=params['year'];
    })

    this.http.getYearlyMatchesForTeam(this.teamName,this.year).subscribe((res)=>{
      console.log('INside the http method');
      console.log(res);
      this.matches=res;
      console.log(this.matches);

      for(let match of this.matches){
        if(this.teamName==match.team1){
          match.teamName=match.team1;
          match.opposition=match.team2;
        }else{
          match.teamName=match.team2;
          match.opposition=match.team1;
        }
      }
    })

  }

}
