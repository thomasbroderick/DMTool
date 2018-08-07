import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'nameFilter'
})
export class NameFilterPipe implements PipeTransform {
  transform(elements): any {
    const results = [];

    elements.forEach(function(elem) {
      results.push(elem.name);
      // results.push(elem);
    });

    return results;
  }
}
