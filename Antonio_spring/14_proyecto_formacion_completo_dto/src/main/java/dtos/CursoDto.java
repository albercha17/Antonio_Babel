package dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Alumno;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {
	
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private Date fechaInicio;
	private List<String> alumnos;
}
