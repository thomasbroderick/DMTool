export class User {
  id: number;
  username: string;
  password: string;
  enabled: boolean;
  role: string;

  constructor(
    $username?: string,
    $password?: string,
    $enabled?: boolean,
    $role?: string
  ) {
    this.username = $username;
    this.password = $password;
    this.enabled = $enabled;
    this.role = $role;
  }
}
