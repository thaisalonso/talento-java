import { TestBed, inject } from '@angular/core/testing';

import { LivrosService } from './livros.service';

describe('LivrosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LivrosService]
    });
  });

  it('should be created', inject([LivrosService], (service: LivrosService) => {
    expect(service).toBeTruthy();
  }));
});
