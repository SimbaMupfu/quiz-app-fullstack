import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { Auth } from '../services/auth';
import { NzMessageService } from 'ng-zorro-antd/message';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [SharedModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  constructor(
    private formBuilder: FormBuilder,
    private authService: Auth,
    private message: NzMessageService,
    private router: Router
  ){}

  validateForm!: FormGroup;

  ngOnInit(){
    this.validateForm = this.formBuilder.group({
      email: [null, Validators.required],
      password: [null, Validators.required]
    })
  }

  submitForm(){
    this.authService.login(this.validateForm.value).subscribe(res=>{
      this.message
      .success(
        `Login Success`,
        { nzDuration: 5000 }
      );
    }, error=>{
      this.message
      .error(
        `Bad credentials`,
        { nzDuration: 5000 }
      );
    })
  }
}
