import { Component, OnInit  } from '@angular/core';
import { GithubService }         from './github.service';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

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
         this.spinnerService.hide();
        }, error => (err) => { }, () => { });
  }

  constructor(
    public githubService: GithubService,protected spinnerService: Ng4LoadingSpinnerService) { 

    }
refresh():void{
  console.log("in refresh");
  this.spinnerService.show();
   this.getRepoLatestCommitData();
}
   ngOnInit() {
     this.spinnerService.show();
        this.getRepoLatestCommitData();
  }
}
