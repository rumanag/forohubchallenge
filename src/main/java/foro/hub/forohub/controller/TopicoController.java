package foro.hub.forohub.controller;

import foro.hub.forohub.domain.curso.Curso;
import foro.hub.forohub.domain.curso.CursoRepository;
import foro.hub.forohub.domain.topico.*;
import foro.hub.forohub.domain.usuario.Usuario;
import foro.hub.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                                    UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroTopico.idUsuario());

        Curso curso = cursoRepository.getReferenceById(datosRegistroTopico.idCurso());

        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico, usuario, curso));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),
              topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getActivo(),
                topico.getStatus(),topico.getCurso().getNombreCurso(),topico.getUsuario().getNombre());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){

        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());
        topico.actualizarTopico(datosActualizaTopico);
//        DatosListadoTopico nuevoTopico = new DatosListadoTopico(topico);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size=4) Pageable paginacion){
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); lista todos los items, activos y no activos
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new)) ;
    }

//     MOSTRAR LOS DATOS DE UN MEDICO EN ESPECIFICO

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id){

        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getActivo(),
                topico.getStatus(),topico.getCurso().getNombreCurso(),topico.getUsuario().getNombre());

        return ResponseEntity.ok(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){

        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarTopico(@PathVariable Long id) {

        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();

        return ResponseEntity.noContent().build();

    }
}
