
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { TeamsPageComponent } from './teams-page/teams-page.component';
import { MatchPageComponent } from './match-page/match-page.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'teams/:teamName',component: TeamsPageComponent},
  { path: 'teams/:teamName/matches/:year',component: MatchPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}
