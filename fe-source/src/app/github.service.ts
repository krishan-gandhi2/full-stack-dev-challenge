import 'rxjs/add/operator/map';

import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class GithubService {
    private apiUrl = "http://localhost:8080/sample/api/repo";

    constructor(private http: HttpClient) { }

    public getRepoLatestCommitData<T>(repoName: string): Observable<T> {

        return this.http.get<T>(this.apiUrl, {
            headers: new HttpHeaders().set('Content-Type', 'application/json')
        });
    }

}