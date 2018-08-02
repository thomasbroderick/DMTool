import { TestBed, inject } from '@angular/core/testing';

import { CampaignNoteService } from './campaign-note.service';

describe('CampaignNoteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CampaignNoteService]
    });
  });

  it('should be created', inject([CampaignNoteService], (service: CampaignNoteService) => {
    expect(service).toBeTruthy();
  }));
});
