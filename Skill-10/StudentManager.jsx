import React, { useState } from 'react';

export default function StudentManager() {
  const [students, setStudents] = useState([
    {id:1,name:"A",course:"CSE"},
    {id:2,name:"B",course:"IT"}
  ]);
  const [newStudent, setNewStudent] = useState({id:"",name:"",course:""});

  const addStudent = () => {
    setStudents([...students, newStudent]);
    setNewStudent({id:"",name:"",course:""});
  };

  const deleteStudent = (id) => {
    setStudents(students.filter(s=>s.id!==id));
  };

  return (
    <div>
      <input placeholder="id" value={newStudent.id} onChange={e=>setNewStudent({...newStudent,id:e.target.value})}/>
      <input placeholder="name" value={newStudent.name} onChange={e=>setNewStudent({...newStudent,name:e.target.value})}/>
      <input placeholder="course" value={newStudent.course} onChange={e=>setNewStudent({...newStudent,course:e.target.value})}/>
      <button onClick={addStudent}>Add</button>

      {students.map(s=>(
        <div key={s.id}>
          {s.name} - {s.course}
          <button onClick={()=>deleteStudent(s.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}
