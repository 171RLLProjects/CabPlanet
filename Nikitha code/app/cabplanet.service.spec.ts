import { TestBed, inject } from '@angular/core/testing';

import { CabplanetService } from './cabplanet.service';

describe('CabplanetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CabplanetService]
    });
  });

  it('should be created', inject([CabplanetService], (service: CabplanetService) => {
    expect(service).toBeTruthy();
  }));
});
