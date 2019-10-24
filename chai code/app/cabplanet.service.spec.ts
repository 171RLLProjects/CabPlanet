import { TestBed, inject } from '@angular/core/testing';

import { CabPlanetService } from './cabplanet.service';

describe('CabPlanetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CabPlanetService]
    });
  });

  it('should be created', inject([CabPlanetService], (service: CabPlanetService) => {
    expect(service).toBeTruthy();
  }));
});
