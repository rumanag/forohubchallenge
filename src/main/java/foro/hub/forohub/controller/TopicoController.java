package foro.hub.forohub.controller;

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

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){

        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroTopico.idUsuario());
        topicoRepository.save(new Topico(datosRegistroTopico, usuario));
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
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size=4) Pageable paginacion){
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); lista todos los items, activos y no activos
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);
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
