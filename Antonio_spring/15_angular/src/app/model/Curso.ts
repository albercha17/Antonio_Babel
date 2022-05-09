import { Alumno } from "./Alumno";

export class Curso {
    idCurso!:number;
    nombre!: string;
    duracion!: number;
    precio!: number;
    fechaInicio! : Date;
    alumnos!:Alumno[];
}
