import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private url = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) {
  }

  getAllStudent(): Observable<any> {
    return this.httpClient.get(this.url + "/student");
  }

  deleteStudent(stuID: number): Observable<any> {
      return this.httpClient.delete(this.url + "/student/" + stuID);
  }

  createStudent(student: Student): Observable<any> {
    return this.httpClient.post(this.url + "/student", student);
  }
}
