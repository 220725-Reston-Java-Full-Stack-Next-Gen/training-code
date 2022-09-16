/*
  Topic: Angular Testing

  - Angular provides a testing framework within its initial dependencies that help us perform behavior-driven test cases for any given component/service/module within the project.

  - What is BDD (behavior driven testing)?
    = a way for software development teams to test the desired user behavior that they want that entity to do.

    - Difference from TDD?
      - BDD is designed to test an application's behavior from the end user's standpoint whereas TDD is focused on testing smaller pieces of functionality in isolation.

      What do we use to do testing in Angular?
      - Karma and Jasmine to make our test cases in Angular
      - Karma = the task runner = used to run our test cases that are located in .spec files throughout the app. Usually it runs with we execute the 'ng test' command
      - Jasmine = a testing framework that is used to create our test cases (aka syntax)
*/
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutComponent } from './about.component';

//this is how you make a test case using 'describe'
//the describe will start our test block and give into about what component we are testing
describe('AboutComponent', () => {
  let component: AboutComponent;
  let fixture: ComponentFixture<AboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AboutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //to make a test case, we would use the it keyword
  it("should have h4 with class 'main-title' to be 'About DBZ API'", () => {
    expect(component.document.querySelector(".main-title").innerHTML).toBeTruthy("About DBZ API");
  });
});
