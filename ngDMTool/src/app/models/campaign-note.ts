import { Campaign } from './campaign';

export class CampaignNote {
         id: number;
         campaign: Campaign;
         text: string;

         constructor($id?: number, $campaign?: Campaign, $text?: string) {
           this.id = $id;
           this.campaign = $campaign;
           this.text = $text;
         }
       }
