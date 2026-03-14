function App() {

const [students,setStudents] = React.useState([
    {id:1,name:"John Doe",course:"Computer Science"},
    {id:2,name:"Jane Smith",course:"Data Science"},
    {id:3,name:"Mike Johnson",course:"Web Development"},
    {id:4,name:"Sarah Wilson",course:"AI & ML"},
    {id:5,name:"David Brown",course:"Cyber Security"}
]);

const [id,setId] = React.useState("");
const [name,setName] = React.useState("");
const [course,setCourse] = React.useState("");

const addStudent = () => {

if(id && name && course){
    setStudents([...students,{id,name,course}]);
    setId("");
    setName("");
    setCourse("");
}
};

const deleteStudent = (id) => {
setStudents(students.filter(student => student.id !== id));
};

return(
<div className="student-manager">

<h2>Student Management Portal</h2>

<div className="add-student-form">

<input
type="text"
placeholder="Student ID"
value={id}
onChange={(e)=>setId(e.target.value)}
/>

<input
type="text"
placeholder="Student Name"
value={name}
onChange={(e)=>setName(e.target.value)}
/>

<input
type="text"
placeholder="Course"
value={course}
onChange={(e)=>setCourse(e.target.value)}
/>

<button onClick={addStudent}>Add Student</button>

</div>

<h3>Students List</h3>

<table className="students-table">

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Action</th>
</tr>
</thead>

<tbody>

{students.map((student)=>(
<tr key={student.id}>
<td>{student.id}</td>
<td>{student.name}</td>
<td>{student.course}</td>
<td>
<button
className="delete-btn"
onClick={()=>deleteStudent(student.id)}
>
Delete
</button>
</td>
</tr>
))}

</tbody>

</table>

</div>
);
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App/>);