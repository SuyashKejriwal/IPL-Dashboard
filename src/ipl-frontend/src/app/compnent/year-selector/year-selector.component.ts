import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-year-selector',
  templateUrl: './year-selector.component.html',
  styleUrls: ['./year-selector.component.css']
})
export class YearSelectorComponent implements OnInit {

  @Input()
  teamName: String;
  
  constructor() { }

  ngOnInit(): void {
  }

}
