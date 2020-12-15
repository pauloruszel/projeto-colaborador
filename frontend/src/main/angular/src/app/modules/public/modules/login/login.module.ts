import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {LoginRoutingModule} from './login-routing.module';
import {LoginComponent} from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {MatDividerModule} from "@angular/material/divider";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import {MatNativeDateModule} from "@angular/material/core";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {CommonModule} from "@angular/common";


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FlexModule,
    FlexLayoutModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    MatDividerModule,
    MatCardModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
  ],
  providers: [LoginComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
})
export class LoginModule { }
