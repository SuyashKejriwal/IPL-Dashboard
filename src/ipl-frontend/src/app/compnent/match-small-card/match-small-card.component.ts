import { Component, Input, OnInit } from '@angular/core';
import { Match } from 'src/app/models/match';

@Component({
  selector: 'app-match-small-card',
  templateUrl: './match-small-card.component.html',
  styleUrls: ['./match-small-card.component.css']
})
export class MatchSmallCardComponent implements OnInit {

  @Input()
  matches: Match[];

  @Input()
  teamName: String;

  modifiedMatches=[];
  constructor() { }

  ngOnInit(): void {
    for(let match of this.matches){
      if(this.teamName==match.team1){
        match.teamName=match.team1;
        match.opposition=match.team2;
      }else{
        match.teamName=match.team2;
        match.opposition=match.team1;
      }
    }

    console.log('Modified matches are ');
    console.log(this.matches);
  }

}
