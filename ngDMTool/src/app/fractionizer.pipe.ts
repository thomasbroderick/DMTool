import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'fractionizer'
})
export class FractionizerPipe implements PipeTransform {

  transform(value: string, args: any[]): string {

    value = value.substring(4);

    if (value === '0.125') {
      return '1/8';
    }
    if (value === '0.25') {
      return '1/4';
    }
    if (value === '0.5') {
      return '1/2';
    }

    return value;
  }

}
