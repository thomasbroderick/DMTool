export class User {
  id: number;
  email: string;
  password: string;
  enabled: boolean;
  role: string;

  constructor(
    $id?: number,
    $email?: string,
    $password?: string,
    $enabled?: boolean,
    $role?: string
  ) {
    this.id = $id;
    this.email = $email;
    this.password = $password;
    this.enabled = $enabled;
    this.role = $role;
  }
}
