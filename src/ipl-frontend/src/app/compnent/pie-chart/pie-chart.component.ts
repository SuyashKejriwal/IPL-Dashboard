import { Component, Input, OnInit } from '@angular/core';
import { TeamDetails } from 'src/app/models/team-details';
import {
  ChartErrorEvent,
  ChartMouseLeaveEvent,
  ChartMouseOverEvent,
  ChartSelectionChangedEvent,
  ChartType,
  Column,
  GoogleChartComponent
} from 'angular-google-charts';
@Component({
  selector: 'app-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent implements OnInit {

  @Input()
  teamInfo: TeamDetails;

  constructor() { }

  //google chart data
  
  typeReferralTracker = ChartType.PieChart;
  dataReferralTracker = [];
  columnNames = ['Name', 'Percentage'];
  optionsReferralTracker = {
    colors: ['#00ff00', '#ff0000'],
    backgroundColor: '#E4E4E4',
    is3D: false,
    
  };
  ReferralTrackerWidth = 500;
  ReferralTrackerHeight = 300;

  ngOnInit(): void {
    this.dataReferralTracker = [
      ['Win', this.teamInfo.totalWins],
      ['Loss',this.teamInfo.totalMatches-this.teamInfo.totalWins],
     
    ];
  }

}
