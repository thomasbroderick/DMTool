import { TestBed, inject } from '@angular/core/testing';

import { PlayerNoteService } from './player-note.service';

describe('PlayerNoteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlayerNoteService]
    });
  });

  it('should be created', inject([PlayerNoteService], (service: PlayerNoteService) => {
    expect(service).toBeTruthy();
  }));
});
