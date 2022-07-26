# Git
Version Control Management Software. A developer's source-code will ultimately need to be changed many times over the course of its use. In order to manage this, we have a recorded timeline of all changes that we can revert back to. To expand onto this, it is not just one timeline, but a branching timeline that can be in different states and be split/merged back together.

## Terminology
- Local & Remote Repositories
    - Local: Repository that is located on a personal computer
    - Remote: Repository that is located on a server that can be accessed by a variety of sources
    - Each Repository houses the source-code that is managed by Git
- Commit
    - A finalized change to a repository
    - It is a static point in the timeline
- Staging
    - A state that collects changes to be prepared and established as a commit
    - The step before committing
- Push & Pull
    - Push: Update a remote repository with commits from the local repository
    - Pull: Retrieves an updated timeline from a remote repository to update the local repository
- Branch
    - An alternate timeline of a repository (local or remote)
    - These timelines split off of another at some commit
        - This means that different branches generally have many commits in common
        - But there are few that are distinct
    - Branches are often synchronized between local and remote repositories
    - At some point (read: commit), these branches can be merged together, combining their commits
- Merge
    - When merging branches, there are sometimes conflicts that arise
        - Has the same file been modified in 2 different ways?
    - When this occurs, Git is unable to decide which to proceed with
        - Which change should kept? Both? Neither? Some partial solution between them?
    - It is up to the developer to resolve these conflicts

## Merge Conflicts

When a Merge Conflict occurs within a file, Git will append contents around the changes to focus the developer to the conflict.

```bash
<<<<<<< HEAD
this is some content to mess with
content to append
=======
totally different content to merge later
>>>>>>> new_branch_to_merge_later
```

Some IDEs have plugins or other integrations to help developers notice and resolve these conflicts.
VSCode in particular has a very nice integration. It highlights the different portions and labels them as HEAD vs incoming change.

This allows the developer to recognize what state they currently have, and which changes are from the incoming merge.

In order to resolve this, the developer must remove the `=======` and `<<<<<<<` and `>>>>>>>` symbols.
In addition, the remaining code should sufficiently handle the logic. The details of how the changes will be kept must be organized by the developer.

So in the end, the result should look like below, if you intended to keep both changes.

```bash
this is some content to mess with
content to append
totally different content to merge later
```

Be careful with this, and do not include files that have not yet resolved their conflicts. Git will allow you to stage and commit files with these symbols still included. The most common scenario is that individuals forget to save the file after the resolve the changes, and then stage and commit the original conflicted state.

## Changing the timeline
As developers, working with Git, we have the ability to manipulate the timeline itself. In general, this can be quite powerful, but you must careful, because these changes will not be able to be rolled back.
This type of operation is permanent.

However, it is sometimes needed. For example, if someone accidentally forgot to save a file before committing a unresolved merge conflict. Or, if a developer accidentally commits environment variables or other sensitive information.

In these scenarios, the timeline itself will always have that information recorded. In order to remove them, we can perform what is called a `rebase`. Specifically, an `interactive rebase` (Using the -i flag).

This allows us to view the log of commits, and make changes to previous commits. We can change the commit messages, we can change the order of commits, or even if commits should have existed at all.
We could also combine multiple commits into one. Among many other operations.

Outside of `interactive` rebases, it is also possible to use regular rebases.

A Git Rebase from one branch to another will take all distinct commits from the source branch and append them to the end of the timeline of the target branch. This can be quite nice in terms of keeping an organized timeline.

By default, Git's merge strategy is to create `merge commits`. These are separate distinct commits that establish the merging process from one branch to another. Some developers prefer to use a rebase strategy to avoid merge commits.
However, there is nothing wrong with merge commits, which is why it is Git's default strategy. Some developers just prefer alternatives.

What is important when collaborating as a team, is that all team members use a consistent strategy.
It's particularly important to pay attention when a new member joins a pre-existing team. As if that team was using a non-default strategy, the new member should adopt the same strategy.

If you establish a new team from the ground up, the team can decide on whatever strategy they wish to use going forwards.

## Git Workflow

In an overall developer's workflow, it is recommended to use the following strategy:

1. Create a new branch from some source branch (generally `main`, `master`, or `dev`)
    - Name this new branch after the `feature` that will developed within this branch
    - It is NOT recommended to name branches after individual people
    - These branches should reflect the purpose of the new timeline
2. Develop the new feature on the individual feature branch
    - This does not have to be a large scale feature
    - It is perfectly reasonable to have a feature branch that only has a few commits, with small changes
    - In fact, to follow Continuous Integration, it is preferable to have the smallest scale feature branches that are reasonable
    - It is common however, the individual feature branches get very large, with hundreds of commits
        - This makes the merging process much more difficult
        - Avoid if possible
        - If you detect that a branch is getting too large, try redesign the plan for that feature
            so that this branch can be merged at a smaller scale
    - You want the feature branch to not get too far away from the source branch
3. Merge the feature branch back into the source branch
    - Using whatever merging strategy that the team has decided upon
    - My personal preference is to `squash` commits and rebase

Additional Note: Sometimes developers want to merge one feature branch into another. This is not recommended, because while it simplifies the first merge, it needlessly complicates the second merge. It also generally exceeds the original intention for the branch.

Sometimes large-scale merges are necessary. It is important to pay attention to these potential scenarios, and attempt to reduce them as much as possible.
Some techniques could be to perform the overall merge in stages/phases.