import { TestBed } from '@angular/core/testing';

import { CorsInterceptorService } from './cors-interceptor.service';

describe('CorsInterceptorService', () => {
  let service: CorsInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CorsInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
