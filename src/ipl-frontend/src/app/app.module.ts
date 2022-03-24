import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TeamTileComponent } from './compnent/team-tile/team-tile.component';
import { TeamsPageComponent } from './teams-page/teams-page.component';
import { PieChartComponent } from './compnent/pie-chart/pie-chart.component';
import { MatchDetailCardComponent } from './compnent/match-detail-card/match-detail-card.component';
import { MatchSmallCardComponent } from './compnent/match-small-card/match-small-card.component';
import { YearSelectorComponent } from './compnent/year-selector/year-selector.component';
import { MatchPageComponent } from './match-page/match-page.component';
import { GoogleChartsModule } from 'angular-google-charts';
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    TeamTileComponent,
    TeamsPageComponent,
    PieChartComponent,
    MatchDetailCardComponent,
    MatchSmallCardComponent,
    YearSelectorComponent,
    MatchPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    GoogleChartsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
