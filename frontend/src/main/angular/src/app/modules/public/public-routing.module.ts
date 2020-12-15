import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PublicContentComponent} from './components/public-content/public-content.component';

const routes: Routes = [
  {
    path: 'public',
    component: PublicContentComponent,
    children: [
      {
        path: 'login',
        loadChildren:() => import('./modules/login/login.module').then(m => m.LoginModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PublicRoutingModule {
}
