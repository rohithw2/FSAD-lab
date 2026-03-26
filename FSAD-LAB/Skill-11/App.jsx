import React, {useEffect,useState} from 'react';

export default function App(){
  const [users,setUsers]=useState([]);

  useEffect(()=>{
    fetch("https://jsonplaceholder.typicode.com/users")
    .then(res=>res.json())
    .then(data=>setUsers(data));
  },[]);

  return (
    <div>
      {users.map(u=>(
        <div key={u.id}>{u.name} - {u.email}</div>
      ))}
    </div>
  );
}
