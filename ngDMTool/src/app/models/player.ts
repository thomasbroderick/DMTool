export class Player {
  id: number;
  name: string;
  maxHp: number;
  currentHp: number;
  initiative: number;
  ac: number;
  perception: number;
  investigation: number;
  insight: number;
  imageUrl: string;

  constructor(
    $id?: number,
    $name?: string,
    $maxHp?: number,
    $currentHp?: number,
    $initiative?: number,
    $ac?: number,
    $perception?: number,
    $investigation?: number,
    $insight?: number,
    $imageUrl?: string
  ) {
    this.id = $id;
    this.name = $name;
    this.maxHp = $maxHp;
    this.currentHp = $currentHp;
    this.initiative = $initiative;
    this.ac = $ac;
    this.perception = $perception;
    this.investigation = $investigation;
    this.insight = $insight;
    this.imageUrl = $imageUrl;
  }
}
