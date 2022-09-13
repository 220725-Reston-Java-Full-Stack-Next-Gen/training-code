import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

//this is how angular couples our app files together to render to the browser
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
