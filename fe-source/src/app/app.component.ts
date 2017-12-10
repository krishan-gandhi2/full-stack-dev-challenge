import { Component, OnInit  } from '@angular/core';
import { GithubService }         from './github.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';
  repoName='angular/angular';
  repoData:any[];
  getRepoLatestCommitData(): void {
    this.githubService
        .getRepoLatestCommitData<any[]>(this.repoName)
        .subscribe((data: any[]) => {
            this.repoData = data;
         console.info(this.repoData);
        }, error => (err) => { }, () => { });
  }

  constructor(
    public githubService: GithubService) { 

    }
refresh():void{
  console.log("in refresh");
   this.getRepoLatestCommitData();
}
   ngOnInit() {
        this.getRepoLatestCommitData();
  }
}
