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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){

        Usuario usuario = usuarioRepository.getReferenceById(datosRegistroTopico.usuarioId());
        topicoRepository.save(new Topico(datosRegistroTopico, usuario));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size=4) Pageable paginacion){
//        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new); lista todos los items, activos y no activos
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizaTopico datosActualizaTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizaTopico.id());
        topico.actualizarTopico(datosActualizaTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void desactivaeliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
