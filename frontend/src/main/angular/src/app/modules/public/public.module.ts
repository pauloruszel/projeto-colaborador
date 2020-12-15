import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PublicRoutingModule} from "./public-routing.module";
import {PublicContentComponent} from "./components/public-content/public-content.component";
import {LoginModule} from "./modules/login/login.module";


@NgModule({
  declarations: [PublicContentComponent],
  imports: [
    CommonModule,
    PublicRoutingModule,
    LoginModule,
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
})
export class PublicModule { }
