# ⁉️ Week 7: Angular & SDLC QC Questions ⁉️
> *These will be asked in QC on the week of Jan. 24th*

1.  What makes a “single page application” (SPA) different from a normal web page?
    
2.  Explain the difference between server-side and client-side rendering
    
3.  What are some features of the Angular framework?
    
4.  How does TypeScript relate to JavaScript? What are the major benefits of using it over JavaScript?
    
5.  List the data types of TypeScript
    
6.  How would you create a new Angular project?
    
7.  What is a component? How would you create one? List some other commands using the Angular CLI
    
8.  What files make up a component? What is the “spec” file used for?
    
9.  Explain the relevance of npm to Angular projects. Which file does npm use to track dependencies?
    
10.  List some decorators for Angular apps

    - Class decorators, e.g. @Component and @NgModule
    - Property decorators for properties inside classes, e.g. @Input and @Output
    - Method decorators for methods inside classes, e.g. @HostListener
    - Parameter decorators for parameters inside class constructors, e.g. @Inject
    
11.  What is the lifecycle of a component? List some lifecycle hooks:

    - There are 8 different stages in the component lifecycle. 
    - Every stage is called as lifecycle hook event. So, we can use these hook events in different phases of our application to obtain control of the components.
    - LiefeCycleHooks include: ngOnInit, ngOnDestroy, ngDoChecks(), ngAfterViewInit()
    
12.  What is a directive and what are the different types? How to tell these directives apart with syntax?
    
13.  What is the benefit of using a directive like NgClass over the class attribute, or even property binding to the class attribute?
    
14.  What is a pipe? A service?
    
15.  How would you create a custom pipe? What about a service?
    
16.  How does dependency injection work in Angular?
    
17.  What is an Angular module? What properties should you set inside it?
    
18.  What’s the difference between a JavaScript module and Angular module? What are some common Angular modules?

- An NgModule is a class marked by the @NgModule decorator with a metadata object that describes how that particular part of the app fits together with the other parts. NgModules are specific to Angular. While classes with an @NgModule decorator are by convention kept in their own files, they differ from JavaScript modules because they include this metadata.
- [NG Module vs. JS Module](https://angular.io/guide/ngmodule-vs-jsmodule)
    
19.  How would you run your unit tests for an Angular project?
    
20.  How have you used the HttpClient? What methods does it have and what do they return?
    
21.  What is an Observable? What’s the difference between it and a Promise?

    > Promises deal with **one** asynchronous event at a time, while observables handle a **sequence** of asynchronous events over a period of time.
    
22.  What forms of data binding does Angular support? Explain the syntax for each
    
23.  What does Webpack do for your ng project?

- Webpack is a tool that lets you compile JavaScript modules, also known as module bundler. Given a large number of files, it generates a single file (or a few files) that run your app. It can perform many operations: helps you bundle your resources
    
24.  How would you implement routing in your project?
    

<hr> 

# SDLC

* What are the steps in the software development lifecycle?
    1. Planning / Requirements gathering
    2. Analysis
    3. Design
    4. Development
    5. Testing
    6. Deployment
    7. Maintenance
    
* What is the difference between Waterfall and Agile methodologies? Explain the benefits and drawbacks of each
    * Waterfall: linear, one-way, unable to make changes; best for projects with fixed, rigid requirements or highly regulated
    * Agile: iterative approach, customer collaboration, responding to change; best for projects in dynamic environments where adaptation required
    
* List some of the principles declared in the Agile manifesto
    * Our highest priority is to satisfy the customer through early and continuous delivery of valuable software
    * Welcome changing requirements
    * Preference for shorter timescale for releases
    * Business people & developers work together
    * Value face to face conversation for communication
    * Working software is the primary measure of progress
    * Sustainable development - should be able to maintain constant pace
    * Continuous attention to technical excellence and good design enhances agility.
    * Simplicity – the art of maximizing the amount of work not done – is essential.
    * The best architectures, requirements, and designs emerge from self-organizing teams.
    * At regular intervals, the team reflects on how to become more effective, then tunes and adjusts its behavior accordingly.


* What specific Agile frameworks exist? What are the main features of each?
    * XP (Extreme programming) - paired programming, code reviews
    * Scrum - sprints, daily standups, story pointing
    * Kanban - kanban board


* What is the Scrum process? Explain each of the Scrum ceremonies
    * Sprint planning meeting
    * Daily scrum (standups)
    * Sprint review
    * Sprint retrospective


* How long is a typical sprint?
    * 2-4 weeks


* What is a "standup" and what should you report about your work?
    * Short, ~15 min total; update on the status of everyone's work
    * What you worked on yesterday, what you plan to work on today, and any blockers you have


* What is the role of a "Scrum master" in a project? What about the "Product owner"?
    * Scrum master is like the cheerleader / advocate for the team; they make sure nothing is in the team's way
    * Product owner sets the vision for the product, helps with generating requirements / user stories and prioritizing


* Explain the following metrics/charts: sprint velocity, burndown chart
    * Velocity - average story points completed per sprint
    * Burndown chart - showing reduction in outstanding story points over the sprint


* What is a Scrum board? Have you used any software tools for your team's Scrum board?
    * Board that has multiple columns as categories for the state of user stories
    * Backlog, Todo, In Progress, Done are typical categories


* What is the "Definition of Done"?
    * The requirements the team agrees have to be met for a user story to be considered "done"
    * Example: all unit tests pass, code is reviewed and merged in feature branch, non-functional requirements met


* Name some technologies teams can use to keep track of progress on different projects, tasks, and due dates.
    * JIRA, Github projects, Trello, Asana