export class Item {
  id: number;
  name: string;
  equipmentCategory: string;
  weaponCategory: string;
  range: string;
  cost: string;
  damage: string;
  weight: string;
  properties: string;
  description: string;
  imageUrl: string;

  constructor(
    $id?: number,
    $name?: string,
    $equipmentCategory?: string,
    $weaponCategory?: string,
    $range?: string,
    $cost?: string,
    $damage?: string,
    $weight?: string,
    $properties?: string,
    $description?: string,
    $imageUrl?: string
  ) {
    this.id = $id;
    this.name = $name;
    this.equipmentCategory = $equipmentCategory;
    this.weaponCategory = $weaponCategory;
    this.range = $range;
    this.cost = $cost;
    this.damage = $damage;
    this.weight = $weight;
    this.properties = $properties;
    this.description = $description;
    this.imageUrl = $imageUrl;
  }
}
