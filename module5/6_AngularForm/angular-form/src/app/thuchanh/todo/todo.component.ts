import {Component, OnInit, SimpleChanges} from '@angular/core';
import {FormControl} from '@angular/forms';

interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}
// tslint:disable-next-line:variable-name
let _id = 1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {

  userInput = new FormControl();
  todos: Array<ITodo> = [];
  constructor() { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnChanges(changes: SimpleChanges): void {
    const {value} = new FormControl();
  }
  onChange() {
    const {value} = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.userInput.setValue('');
    }
  }
  toggleTodo(i) {
    this.todos[i].complete = !this.todos[i].complete;
  }

}
