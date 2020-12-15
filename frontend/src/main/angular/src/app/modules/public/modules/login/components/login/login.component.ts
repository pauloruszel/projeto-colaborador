import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.iniciarFormulario();
  }

  iniciarFormulario() {
    this.form = this.formBuilder.group({
      usuario: [null, [Validators.required]],
      senha: [null, [Validators.required]],
    });

  }

  hasErros(controlName: string, errorName: string): any {
    return this.form.controls[controlName].hasError(errorName);
  }

  create(value: any): string {
    return 'objeto criado';
  }

  recuperarSenha() {

  }

  cadastrarColaborador() {

  }
}
