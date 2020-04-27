import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MyNavComponent} from './my-nav/my-nav.component';
import {LayoutModule} from '@angular/cdk/layout';
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import {FirstPageComponent} from './first-page/first-page.component';
import {SecondPageComponent} from './second-page/second-page.component';
import {ThirdPageComponent} from './third-page/third-page.component';
import {AppService} from './app.service';
// @ts-ignore
import {CountdownModule} from 'ngx-countdown';
import {FormsModule} from '@angular/forms';

const appRoutes: Routes = [
  {path: 'first-page', component: FirstPageComponent},
  {path: 'second-page', component: SecondPageComponent},
  {path: 'third-page', component: ThirdPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MyNavComponent,
    FirstPageComponent,
    SecondPageComponent,
    ThirdPageComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    HttpClientModule,
    MatGridListModule,
    MatFormFieldModule,
    CountdownModule,
    FormsModule,
    MatInputModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
