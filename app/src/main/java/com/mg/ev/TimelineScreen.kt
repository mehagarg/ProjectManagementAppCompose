package com.mg.ev

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mg.ev.ui.typography

enum class Status {
    New,
    InProgress,
    Review,
    Done
}

class Project(
        val id: Int,
        val title: String,
        val date: String,
        val days: Int,
        val status: Status,
        val users: List<User>,
        val tasks: List<Task>
)

class Task(
        val id: Int,
        val timeCode: String,
        val title: String,
        val tag: String,
        val assignee: List<User>,
        val status: Status,
        val commentCount: Int,
        val attachmentCount: Int
)

class User(
        val id: Int,
        val name: String
)

val zachary = User(
        id = 2,
        name = "Zachary Butler"
)
val mary = User(
        id = 3,
        name = "Mary Brown"
)
val sarah = User(
        id = 4,
        name = "Sarah Murphy"
)
val mockProject = Project(
        id = 1,
        title = "Create additional pages",
        date = "Dec 18, 2019",
        days = 3,
        status = Status.InProgress,
        users = listOf(zachary, mary, sarah),
        tasks = listOf(
                Task(
                        id = 163,
                        title = "Contact Page",
                        timeCode = "24.19",
                        tag = "#Design",
                        assignee = listOf(zachary),
                        commentCount = 3,
                        status = Status.InProgress,
                        attachmentCount = 5,
                ),
                Task(
                        id = 158,
                        title = "Calculator Page",
                        timeCode = "24.19",
                        tag = "#Design",
                        assignee = listOf(sarah, mary),
                        status = Status.Done,
                        commentCount = 8,
                        attachmentCount = 2,
                ),
                Task(
                        id = 163,
                        title = "Technical Task",
                        timeCode = "23.19",
                        tag = "#Design",
                        assignee = listOf(zachary),
                        status = Status.New,
                        commentCount = 3,
                        attachmentCount = 5,
                ),
                Task(
                        id = 159,
                        title = "Technical Task",
                        timeCode = "23.19",
                        tag = "#Design",
                        assignee = listOf(mary),
                        status = Status.Done,
                        commentCount = 3,
                        attachmentCount = 5,
                )
        )
)

@Composable
fun TimelineScreen(project: Project = mockProject) {
    Column {
        Text(project.title, style = typography.h1)
        Row {
            Text("${project.days} days", style = typography.body2)
            Text("|", modifier = Modifier.padding(horizontal = 4.dp), style = typography.body2)
            Text(project.date, style = typography.body2)
        }
        AvatarList(users = project.users)
    }
}

@Composable
fun AvatarList(users: List<User>) {

    Row{
        for(user in users){
            Avatar(user)
        }
    }


}

@Composable
fun Avatar(user: User, modifier: Modifier = Modifier) {
    Box(
            modifier = modifier
                    .background(Color.White, CircleShape)
                    .padding(2.dp)
                    .background(Color(0xFFBB86FC), CircleShape)
                    .size(48.dp)
    )

}