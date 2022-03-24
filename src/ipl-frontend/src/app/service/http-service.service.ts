import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Team } from '../models/team';
import { TeamDetails } from '../models/team-details';
import { Match } from '../models/match';
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  baseUrl="http://localhost:8080";
  constructor(private http: HttpClient) { }

  getAllTeams(): Observable<Team[]>{
    return this.http.get<Team[]>(this.baseUrl+'/team');
  }

  getTeamInfo(teamName): Observable<TeamDetails>{
    return this.http.get<TeamDetails>(this.baseUrl+'/team/'+teamName);
  }

  getYearlyMatchesForTeam(teamName,year): Observable<Match[]>{
    return this.http.get<Match[]>(this.baseUrl+'/team/'+teamName+'/matches',{
      params:{
        year: year
      }
    })
  }

}
