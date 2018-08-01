import { User } from './user';

export class Spell {
  id: number;
  name: string;
  description: string;
  higherLevel: string;
  range: string;
  components: string;
  material: string;
  ritual: string;
  duration: string;
  concentration: string;
  castingTime: string;
  level: string;
  school: string;
  classes: string;
  user: User;

  constructor(
    $id?: number,
    $name?: string,
    $description?: string,
    $higherLevel?: string,
    $range?: string,
    $components?: string,
    $material?: string,
    $ritual?: string,
    $duration?: string,
    $concentration?: string,
    $castingTime?: string,
    $level?: string,
    $school?: string,
    $classes?: string,
    $user?: User
  ) {
    this.id = $id;
    this.name = $name;
    this.description = $description;
    this.higherLevel = $higherLevel;
    this.range = $range;
    this.components = $components;
    this.material = $material;
    this.ritual = $ritual;
    this.duration = $duration;
    this.concentration = $concentration;
    this.castingTime = $castingTime;
    this.level = $level;
    this.school = $school;
    this.classes = $classes;
    this.user = $user;
  }
}
