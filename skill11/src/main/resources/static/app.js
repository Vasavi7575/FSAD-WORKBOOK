const { useState, useEffect } = React;

/* ---------- Dashboard ---------- */

function Dashboard({ setPage }) {

return (

<div className="container">

<h2>React API Integration Dashboard</h2>

<button onClick={() => setPage("local")}>Local Users</button>

<button onClick={() => setPage("users")}>Users API</button>

<button onClick={() => setPage("posts")}>Fake API Posts</button>

</div>

);

}


/* ---------- Local JSON Users ---------- */

function LocalUserList({ setPage }) {

const [users, setUsers] = useState([]);
const [loading, setLoading] = useState(true);

useEffect(() => {

fetch("users.json")
.then(res => res.json())
.then(data => {
setUsers(data);
setLoading(false);
})
.catch(() => setLoading(false));

}, []);

if (loading) return <p>Loading...</p>;

return (

<div className="container">

<h3>Local Users</h3>

<button onClick={() => setPage("home")}>Back to Home</button>

<table>

<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
</tr>
</thead>

<tbody>

{users.map(user => (
<tr key={user.id}>
<td>{user.name}</td>
<td>{user.email}</td>
<td>{user.phone}</td>
</tr>
))}

</tbody>

</table>

</div>

);

}


/* ---------- JSONPlaceholder Users ---------- */

function UserList({ setPage }) {

const [users, setUsers] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState("");

useEffect(() => {

fetch("https://jsonplaceholder.typicode.com/users")
.then(res => res.json())
.then(data => {
setUsers(data);
setLoading(false);
})
.catch(() => {
setError("Error loading users");
setLoading(false);
});

}, []);

if (loading) return <p>Loading...</p>;
if (error) return <p>{error}</p>;

return (

<div className="container">

<h3>Users API</h3>

<button onClick={() => setPage("home")}>Back to Home</button>

<table>

<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
</tr>
</thead>

<tbody>

{users.map(user => (
<tr key={user.id}>
<td>{user.name}</td>
<td>{user.email}</td>
<td>{user.phone}</td>
</tr>
))}

</tbody>

</table>

</div>

);

}


/* ---------- Fake API Posts (Axios) ---------- */

function FakePostList({ setPage }) {

const [posts, setPosts] = useState([]);
const [filter, setFilter] = useState("");

const loadPosts = () => {

axios.get("https://dummyjson.com/posts")
.then(res => {
setPosts(res.data.posts);
});

};

useEffect(() => {
loadPosts();
}, []);

const filteredPosts = filter
? posts.filter(p => p.userId == filter)
: posts;

return (

<div className="container">

<h3>Fake API Posts</h3>

<button onClick={() => setPage("home")}>Back to Home</button>

<button onClick={loadPosts}>Refresh</button>

<br/><br/>

<select onChange={(e) => setFilter(e.target.value)}>

<option value="">All Users</option>
<option value="1">User 1</option>
<option value="2">User 2</option>
<option value="3">User 3</option>

</select>

{filteredPosts.map(post => (

<div key={post.id} className="card">

<h4>{post.title}</h4>

<p>{post.body}</p>

</div>

))}

</div>

);

}



function App() {

const [page, setPage] = useState("home");

if (page === "local") return <LocalUserList setPage={setPage} />;
if (page === "users") return <UserList setPage={setPage} />;
if (page === "posts") return <FakePostList setPage={setPage} />;

return <Dashboard setPage={setPage} />;

}

ReactDOM.createRoot(document.getElementById("root")).render(<App />);